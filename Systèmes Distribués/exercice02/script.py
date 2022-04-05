import requests
import argparse
import json

parser = argparse.ArgumentParser(description='Trouver la ville la plus chaude')
parser.add_argument('TOWNS', metavar='T', type=str, nargs='+', help='Towns')
parser.add_argument('-j', dest='json', action='store_true', help='output json')

args = parser.parse_args()

tempMax = -30


for i in args.TOWNS:
    demande = requests.get('https://wttr.in/'+i+'?format=j1')
    sortie = demande.json()
    temperature = int(sortie['current_condition'][0]['temp_C'])
    if(temperature > tempMax):
        tempMax = temperature
        ville = i

for i in args.TOWNS:
    demande = requests.get('https://wttr.in/'+i+'?format=j1')
    sortie = demande.json()
    if(i == ville):
        print(i + ' - Temperature actuelle : ' + sortie['current_condition'][0]['temp_C'] + '°C')
    else:
        print('Il fait moins chaud à ' + i + ' : ' + sortie['current_condition'][0]['temp_C'] + '°C')
