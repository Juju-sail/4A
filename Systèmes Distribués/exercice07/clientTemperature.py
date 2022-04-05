import capnp
import temperature_capnp

# Creation client :
client = capnp.TwoPartyClient('localhost:60000')
# Recuperation de WeatherMap dans le capnp : 
weathermap = client.bootstrap().cast_as(temperature_capnp.WeatherMap)
# Requete :
request = weathermap.findTown().town.currentTemperature()
result = request.wait() # Attente du resultat de la requette
# Affichage vaeur de la requette : 
print(result.temperature.value)
