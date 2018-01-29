import requests
import json

#Google api URI
URI = "http://maps.googleapis.com/maps/api/geocode/json?latlng=44.4647452,7.3553838&sensor=true"


r = requests.get(URI)
print(json.loads(r.text))





