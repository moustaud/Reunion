package tools

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ClusteringController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Clustering.list(params), model:[clusteringCount: Clustering.count()]
    }

    def show(Clustering clustering) {
        respond clustering
    }

    def create() {
        respond new Clustering(params)
    }

    @Transactional
    def save(Clustering clustering) {
        if (clustering == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (clustering.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond clustering.errors, view:'create'
            return
        }

        clustering.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'clustering.label', default: 'Clustering'), clustering.id])
                redirect clustering
            }
            '*' { respond clustering, [status: CREATED] }
        }
    }

    def edit(Clustering clustering) {
        respond clustering
    }

    @Transactional
    def update(Clustering clustering) {
        if (clustering == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (clustering.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond clustering.errors, view:'edit'
            return
        }

        clustering.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'clustering.label', default: 'Clustering'), clustering.id])
                redirect clustering
            }
            '*'{ respond clustering, [status: OK] }
        }
    }

    @Transactional
    def delete(Clustering clustering) {

        if (clustering == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        clustering.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'clustering.label', default: 'Clustering'), clustering.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'clustering.label', default: 'Clustering'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
