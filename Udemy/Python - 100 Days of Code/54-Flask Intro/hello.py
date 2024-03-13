from flask import Flask

app = Flask(__name__)

@app.route("/")
def hello_world():
    return "<p>Hello, New World!</p>"

def make_bold(string):
    return f"<b>{string}</b>"



@app.route("/bye/<name>")
@make_bold(name)
def say_bye(name):
    return "Byee bye " + name


if __name__ == "__main__":
    app.run(debug=True)

