package blagger

import grails.test.mixin.*
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Categories)
@TestMixin(GrailsUnitTestMixin)
class CategoriesSpec extends Specification {

    @Unroll
    def 'a category has tag name'() {
        when:
            def category = new Categories(tagName: tagName)

        then:
            validate == category.validate()
            errorCode == category.errors['tagName']?.code

        where:
            tagName | validate | errorCode
            null    | false    | 'nullable'
            'tag'   | true     | null
    }
	
	def 'findAllTagNames retrieves tag names of all categories'() {
		given:
			new Categories(tagName: 'candid').save()
			new Categories(tagName: 'jlt').save()

		when:
			def tagNames = Categories.findAllTagNames()

		then:
			['candid', 'jlt'] == tagNames
	}
}
