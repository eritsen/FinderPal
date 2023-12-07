from flask import Flask, request
from flask_cors import CORS
import keyboard
import threading
import json

app = Flask(__name__)
CORS(app)

def key_press(key):
    if key == 'w':
        keyboard.press('w')
        keyboard.release('w')
    elif key == 'a':
        keyboard.press('a')
        keyboard.release('a')
    elif key == 's':
        keyboard.press('s')
        keyboard.release('s')
    elif key == 'd':
        keyboard.press('d')
        keyboard.release('d')

@app.route('/keypress', methods=['POST'])
def key_event():
    try:
        data = request.get_json()
        if data and 'key' in data:
            key = data['key']
            threading.Thread(target=key_press, args=(key,)).start()
            return "Key '{}' pressed!".format(key)
        else:
            return "Invalid JSON payload", 400
    except Exception as e:
        return f"Error: {e}", 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', debug=True)
