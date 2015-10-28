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
    [
      data: workerDepartmentService.getWorkerDepartmentData(),
      emergencyNumbers: grailsApplication.config.ni.edu.uccleon.emergencyNumbers
    ]
  }

  @Secured("ROLE_ADMIN")
  def create() {

  }

  def printExtencionsList() {
    def data =  workerDepartmentService.getWorkerDepartmentData()
    def emergencyNumbers = grailsApplication.config.ni.edu.uccleon.emergencyNumbers
    def pdfBuilder = new PdfDocumentBuilder(response.outputStream)
    def customTemplate = {
      "document" font: [family: "Helvetica", size: 8.pt], margin: [top: 0.3.inches]
      "cell.th" font: [bold: true]
    }

    pdfBuilder.create {
      document(
        template: customTemplate,
        footer: { info ->
          table(border: [size: 0]) {
            row {
              cell "Impreso: ${info.dateGenerated.format('yyyy-MM-dd hh:mm')}"
            }
          }
        }) 
      {

        heading1 "Directorio de extensiones", align: "center"

        table(columns: [1, 2 , 2, 2], padding: 5.px) {
          row {
            cell "Extension", style: "th", align: "center"
            cell "Departamento", style: "th"
            cell "Coordinador", style: "th"
            cell "Colaborador", style: "th"
          }
          data.each { d ->
            if (d.meta.size() == 1) {
              row {
                cell d.ext, align: "center"
                cell d.meta[0].department
                cell d.meta[0].manager
                cell d.meta[0].collaborators.join(", ")
              }
            }
            else {
              d.meta.eachWithIndex { m, index ->
                row {
                  if (index == 0) {
                    cell d.ext, rowspan: d.meta.size(), align: "center";
                  }
                  cell m.department
                  cell m.manager
                  cell m.collaborators.join(", ")
                }
              }
            }
          }
          row {
            cell "190", align: "center"
            cell "Porton principal", colspan: 3
          }
          row {
            cell "200", align: "center"
            cell "Porton estacionamiento", colspan: 3
          }
        }

        paragraph(align: "center") {
          text "Bomberos "
          text emergencyNumbers.firefighters, font: [bold: true]
          text " Policia "
          text emergencyNumbers.police, font: [bold: true]
          text " Cruz roja "
          text  emergencyNumbers.redCross, font: [bold: true]
        }
      }
    }

    response.contentType = "application/pdf"
    response.setHeader("Content-disposition", "attachment;filename=test.pdf")
    response.outputStream << out.toByteArray()
    response.outputStream.flush()
  }
}
