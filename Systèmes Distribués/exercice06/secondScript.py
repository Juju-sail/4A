import cbor2
from cbor2 import dumps, load, CBORTag
import requests
import binascii
import json

# Ouverture du .cborg créé grace au 1er script :
with open("notes.cbor", "rb") as cborFile:
    data = load(cborFile)

#print(data)

notesListe = [] # liste comportant les json_note du fichier 

for note in data: # Pour chaque note du fichier,
    json_note = {}
    for element in note: # Et pour chaque élément des notes
        if isinstance(element, CBORTag):
            if element.tag == 500:
                key = "id"
            if element.tag == 501:
                key = "titre"
            if element.tag == 502:
                key = "contenu"
            if element.tag == 503:
                key = "proprietaire"
            if element.tag == 504:
                key = "categories"
            json_note[key] = element.value # On crée les fields de la note (ex : note["id"] = "df15b876-2d03-423b-b394-2d812cc24d2e")
    notesListe.append(json_note)

json_str = json.dumps(notesListe, separators=(',', ':')) # On transforme les separateurs pour correspondre à la nomenclature json

#print(json_str)

# Creation fichier .json :
with open("notes.json", "w") as jsonFile:
    jsonFile.write(json_str)