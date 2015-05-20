import blagger.Post

class BootStrap {

    def init = { servletContext ->

        def content = """\
        <dl>
            <dt>Blagger</dt>
            <dd>
                <ol>
                    <li>Please Note</li>
                        <ol>
                            <li>The project is using Java 8</li>
                            <li>Gatling version is 2.4.4</li>
                            <li>There are few version changes as well which you can find in buildconfig file</li>
                        </ol>
                </ol>
            </dd>
        </dl>
        """

        Post post = new Post(title: 'Accepted your challenge, please contact me via email provided...', email: 'prakhu@gmail.com', content: content)
        post.save()

    }
    def destroy = {
    }
}
