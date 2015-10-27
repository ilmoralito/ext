class UrlMappings {

  static mappings = {
    "/$controller/$action?/$id?(.$format)?"{
      constraints {
        // apply constraints here
      }
    }

    "/"(controller: "workerDepartments", action: "index")
    //"/"(controller:"request", action:"activity")
    "500"(view:'/error')
    "404"(view:'/notFound')
  }
}
