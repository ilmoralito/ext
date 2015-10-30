import ni.edu.uccleon.*

class BootStrap {

  def init = { servletContext ->
    //spring security core
    def adminRole = new Role("ROLE_ADMIN").save()
    def userRole = new Role("ROLE_USER").save()

    def testUser = new User("me", "me@ucc.edu.ni", "password").save()

    UserRole.create testUser, adminRole, true

    assert User.count() == 1
    assert Role.count() == 2
    assert UserRole.count() == 1

    //workers
    def arnoldo = new Worker(fullName: "Arnoldo Mendoza", email: "arnoldo.mendoza@ucc.edu.ni").save failOnError: true
    def lucia = new Worker(fullName: "Lucia Pineda", email: "lucia.pineda@ucc.edu.ni").save failOnError: true
    def janeth = new Worker(fullName: "Janeth Laguna", email: "janeth.laguna@ucc.edu.ni").save failOnError: true
    def ofilio = new Worker(fullName: "Ofilio Hernandez", email: "ofilio.hernandez@ucc.edu.ni").save failOnError: true
    def deyanira = new Worker(fullName: "Deyanira Obando", email: "deyanira.obando@ucc.edu.ni").save failOnError: true
    def esperanza = new Worker(fullName: "Esperanza Vanegas", email: "esperanza.vanegas@ucc.edu.ni").save failOnError: true
    def elisa = new Worker(fullName: "Elisa Pao", email: "elisa.pao@ucc.edu.ni").save failOnError: true
    def maria = new Worker(fullName: "Maria Calderon", email: "maria.calderon@ucc.edu.ni").save failOnError: true
    def daysi = new Worker(fullName: "Daysi Torres", email: "daysi.torrez@ucc.edu.ni").save failOnError: true
    def keyra = new Worker(fullName: "Keyra Caballero", email: "keyra.caballero@ucc.edu.ni").save failOnError: true
    def nelvar = new Worker(fullName: "Nelvar Valladares", email: "nelvar.valladares@ucc.edu.ni").save failOnError: true
    def yesennia = new Worker(fullName: "Yessenia Valverde", email: "yessenia.valverde@ucc.edu.ni").save failOnError: true
    def norma = new Worker(fullName:"Norma Lazo", email: "norma.lazo@ucc.edu.ni").save failOnError: true
    def marcia = new Worker(fullName:"Marcia Sandino", email: "marcia.sandino@ucc.edu.ni").save failOnError: true
    def grethel = new Worker(fullName:"Grethel Hernandez", email: "grethel.hernandez@ucc.edu.ni").save failOnError: true
    def rider = new Worker(fullName:"Rider Sarria", email: "rider.sarria@ucc.edu.ni").save failOnError: true
    def leonte = new Worker(fullName:"Leonte Paiz", email: "leonte.paiz@ucc.edu.ni").save failOnError: true

    assert Worker.count() == 17

    //departments
    def bodega = new Department(name: "Bodega", extensionNumber: 158).save failOnError: true
    def sAdmin = new Department(name: "Supervision administrativa", extensionNumber: 116).save failOnError: true
    def sAcade = new Department(name: "Supervicion academica", extensionNumber: 116).save failOnError: true
    def higiene = new Department(name: "Higiene y seguridad", extensionNumber: 116).save failOnError: true
    def finances = new Department(name: "Finanzas", extensionNumber: 118).save failOnError: true
    def charge = new Department(name: "Cartera y cobro", extensionNumber: 119).save failOnError: true
    def fese = new Department(name: "FESE", extensionNumber: 115).save failOnError: true
    def industrial = new Department(name: "Industrial", extensionNumber: 115).save failOnError: true
    def registro = new Department(name: "Registro", extensionNumber: 199).save failOnError: true
    def biblioteca = new Department(name: "Biblioteca", extensionNumber: 16).save failOnError: true
    def vidaEstudiantil = new Department(name: "Vida estudiantil", extensionNumber: 188).save failOnError: true

    assert Department.count() == 11

    //WorkerDepartment
    def wd1 = new WorkerDepartment(worker: arnoldo, department: bodega, position: "Manager").save failOnError: true
    def wd2 = new WorkerDepartment(worker: lucia, department: sAdmin, position: "Manager").save failOnError: true
    def wd3 = new WorkerDepartment(worker: janeth, department: sAcade, position: "Manager").save failOnError: true
    def wd4 = new WorkerDepartment(worker: ofilio, department: higiene, position: "Manager").save failOnError: true
    def wd5 = new WorkerDepartment(worker: deyanira, department: finances, position: "Manager").save failOnError: true
    def wd6 = new WorkerDepartment(worker: esperanza, department: finances, position: "Collaborator").save failOnError: true
    def wd7 = new WorkerDepartment(worker: elisa, department: charge, position: "Manager").save failOnError: true
    def wd8 = new WorkerDepartment(worker: maria, department: charge, position: "Collaborator").save failOnError: true
    def wd9 = new WorkerDepartment(worker: daysi, department: fese, position: "Manager").save failOnError: true
    def wd10 = new WorkerDepartment(worker: keyra, department: fese, position: "Collaborator").save failOnError: true
    def wd11 = new WorkerDepartment(worker: nelvar, department: industrial, position: "Manager").save failOnError: true
    def wd12 = new WorkerDepartment(worker: yesennia, department: industrial, position: "Collaborator").save failOnError: true
    def wd13 = new WorkerDepartment(worker: norma, department: registro, position: "Manager").save failOnError: true
    def wd14 = new WorkerDepartment(worker: marcia, department: registro, position: "Collaborator").save failOnError: true
    def wd15 = new WorkerDepartment(worker: grethel, department: registro, position: "Collaborator").save failOnError: true
    def wd16 = new WorkerDepartment(worker: rider, department: registro, position: "Collaborator").save failOnError: true
    def wd17 = new WorkerDepartment(worker: leonte, department: registro, position: "Collaborator").save failOnError: true

    assert WorkerDepartment.count() == 17
  }
  def destroy = {
  }
}
