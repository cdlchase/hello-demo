package hello.demo

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import grails.converters.*

//@Secured(['ROLE_DRIVER'])
//@Resource(uri = '/api/products')
class ProductController extends RestfulController {
    static responseFormats = ['json', 'xml']
    ProductController() {
        super(Product)
    }
    def search(String q, Integer max ) {
        if (q) {
            def query = Product.where {
                name ==~ "%${q}%"
            }
            respond query.list(max: Math.min( max ?: 10, 100))
        }
        else {
            respond([])
        }
    }
}
