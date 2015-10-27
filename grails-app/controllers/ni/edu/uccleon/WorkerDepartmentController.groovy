package ni.edu.uccleon

import grails.plugin.springsecurity.annotation.Secured
import com.craigburke.document.builder.PdfDocumentBuilder

class WorkerDepartmentController {
  def workerDepartmentService

  static allowedMethods = [
    index: "GET",
    create: ["GET", "POST"]
  ]

  def index() {
    def criteria = WorkerDepartment.createCriteria()
    def result = criteria.list {
      projections {
        groupProperty "department"
      }
    }

    def data = result.groupBy { it.extensionNumber }.collect { o ->
      [
        ext: o.key,
        meta: o.value.collect { d ->
          [
            department: d,
            manager: workerDepartmentService.getWorkers("Manager", d),
            collaborators: workerDepartmentService.getWorkers("Collaborator", d)
          ]
        }
      ]
    }

    [data: data]
  }

  @Secured("ROLE_ADMIN")
  def create() {

  }

  @Secured("ROLE_ADMIN")
  def printExtencionsList() {
    def data = WorkerDepartment.list()
    def pdfBuilder = new PdfDocumentBuilder(response.outputStream)

    pdfBuilder.create {
        document {
          heading1 "Workers"

          table {
            row {
              cell "Extencion"
              cell "Departamento"
              cell "Coordinador"
              cell "Colaborador(es)"
            }
            data.each { d ->
              row {
                cell d.department.extensionNumber
                cell d.department.name
                cell d.worker.fullName
                cell d.worker.fullName
              }
            }
          }
        }
    }

    response.contentType = "application/pdf"
    response.setHeader("Content-disposition", "attachment;filename=test.pdf")
    response.outputStream << out.toByteArray()
    response.outputStream.flush()
  }
}
