package blagger

class Categories {

    String tagName

    static belongsTo = Post

    static constraints = {
        tagName blank: false
    }

    static findAllTagNames() {
        findAll().collect { it.tagName }
    }
}
