package CarpoolingProyect.CarpoolingProyect.Model

data class RouteStopRequest (
    var routeId:Long=0,
    var routeStops:List<RouteStop>
)