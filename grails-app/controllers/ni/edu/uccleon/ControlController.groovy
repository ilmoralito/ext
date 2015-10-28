package ni.edu.uccleon

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class ControlController {

  def index() { }
}
