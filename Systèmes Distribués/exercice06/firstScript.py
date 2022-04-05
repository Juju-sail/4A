import cbor2
from cbor2 import dumps, loads, CBORTag
import requests
import binascii

tagified = []
# Requête de récuperation des notes du serveur
json = requests.get("http://192.168.1.195:8080/notes").json()
#print(json)

# On associe les tags aux fields pour chaque note :
for note in json:
    myNote = [
            CBORTag(500, note["id"]),
            CBORTag(501,note["titre"]), 
            CBORTag(502, note["contenu"]),
            CBORTag(503, note["proprietaire"]),
            CBORTag(504, note["categories"])
            ]
    tagified.append(myNote) # On incremente la liste de notes

#print(tagified)
cbor_data = dumps(tagified)
#print(binascii.hexlify(cbor_data))

# Creation d'un fichier .cbor contenant les notes du serveur :
with open("notes.cbor", "wb") as output_file:
        output_file.write(cbor_data)
