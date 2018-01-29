package hello.demo


import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.Resource
import org.grails.datastore.gorm.GormEntity

@GrailsCompileStatic
//@Secured(['ROLE_DRIVER'])
//@Resource(uri = '/api/products')
class Product implements GormEntity<Product> {

    String name
    Double price

    static constraints = {
        name blank:false
        price range:0.0..1000.00
    }
}
