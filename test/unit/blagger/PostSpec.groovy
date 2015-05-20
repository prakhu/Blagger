package blagger

import grails.test.mixin.*
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.*
/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(Post)
class PostSpec extends Specification {
	@Shared postData = [
		title: 'test',
		email: 'test@test.com',
		content: 'test'
	]

	@Unroll
	def 'the title has at least 3 characters'() {
		when:
			def post = new Post(postData << [title: title])

		then:
			validate == post.validate()
			errorCode == post.errors['title']?.code

		where:
			title  | validate | errorCode
			null   | false    | 'nullable'
			'12'   | false    | 'minSize.notmet'
			'123'  | true     | null
			'1234' | true     | null
	}

	@Unroll
	def 'the email is a valid email address'() {
		when:
			def post = new Post(postData << [email: email])

		then:
			validate == post.validate()
			errorCode == post.errors['email']?.code

		where:
			email              | validate | errorCode
			null               | false    | 'nullable'
			'prakhu'           | false    | 'email.invalid'
			'prakhu@gmail.com' | true     | null
	}

	@Unroll
	def 'there is some content'() {
		when:
			def post = new Post(postData << [content: content])

		then:
			validate == post.validate()
			errorCode == post.errors['content']?.code

		where:
			content   | validate | errorCode
			null      | false    | 'nullable'
			'content' | true     | null
	}
   
}
