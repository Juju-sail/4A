#!/usr/bin/env python3

import requests
import argparse
import json

parser = argparse.ArgumentParser(description='Find a nice city.')
parser.add_argument('TOWNS', metavar='V', type=str, nargs='+',
                    help='Towns')
parser.add_argument('-j', dest='json', action='store_true',
                    help='output json')

args = parser.parse_args()

result = {}
best_feels_like = float("-inf")
for town in args.TOWNS:
    r = requests.get(f"https://wttr.in/{town}?format=j1")
    if r.ok:
        weather = r.json()["current_condition"][0]
        feels_like = float(weather["FeelsLikeC"])
        temp = float(weather["temp_C"])
        result[town] = {"temp": temp, "feels_like": feels_like}
        if feels_like > best_feels_like:
            best_feels_like = feels_like
            best_town = town

best_temp = result[best_town]['temp']
if not args.json:
    print(f"Best:\n{best_town}\t{best_temp}°C ({best_feels_like}°C)")
    print("")

for town in args.TOWNS:
    if not town == best_town:
        result[town]['is_best'] = False
        result[town]['diff_temp'] = result[town]['temp'] - best_temp
        result[town]['diff_feels_like'] = result[town]['feels_like'] - best_feels_like
    else:
        result[town]['is_best'] = True
        result[town]['diff_temp'] = None
        result[town]['diff_feels_like'] = None

if not args.json:
    for town in args.TOWNS:
        if result[town]['is_best']:
            continue
        print(f"{town}\t{result[town]['temp']}°C ({result[town]['feels_like']}°C) [{result[town]['diff_temp']}°C ({result[town]['diff_feels_like']}°C)]")
else:
    print(json.dumps({"best_town" : best_town, "towns" : result}, indent=2))