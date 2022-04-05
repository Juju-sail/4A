import capnp
!import temperature_capnp

class TownImpl(temperature_capnp.Town.Server):
    def currentTemperature(self, _context, **kwargs):
        _context.results.temperature.value = 15.6


class WeatherMapImpl(temperature_capnp.WeatherMap.Server):
    "Implementation of the WeatherMap Cap'n Proto interface."
    def findTown(self, _context, **kwargs):
        _context.results.town = TownImpl()

server = capnp.TwoPartyServer('*:60000', bootstrap=WeatherMap())
server.run_forever()
