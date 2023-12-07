import requests

# Change the key value to test different keys
key_to_press = 'w'

response = requests.post('http://127.0.0.1:5000/keypress', data=key_to_press)
print(response.text)
