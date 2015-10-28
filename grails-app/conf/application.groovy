// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.successHandler.defaultTargetUrl = "/control"
grails.plugin.springsecurity.userLookup.userDomainClassName = "ni.edu.uccleon.User"
grails.plugin.springsecurity.userLookup.authorityJoinClassName = "ni.edu.uccleon.UserRole"
grails.plugin.springsecurity.authority.className = "ni.edu.uccleon.Role"
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	"/":                ["permitAll"],
	"/error":           ["permitAll"],
	"/index":           ["permitAll"],
	"/index.gsp":       ["permitAll"],
	"/shutdown":        ["permitAll"],
	"/assets/**":       ["permitAll"],
	"/**/js/**":        ["permitAll"],
	"/**/css/**":       ["permitAll"],
	"/**/images/**":    ["permitAll"],
	"/**/favicon.ico":  ["permitAll"],
	"/workerDepartment/index":  ["permitAll"],
	"/workerDepartment/printExtencionsList":  ["permitAll"]
]

//app config
ni.edu.uccleon.emergencyNumbers = [
	redCross: "129",
	police: "126",
	firefighters: "115"
]
