from flask import Flask, render_template

app = Flask(__name__)

@app.route("/hello")
def sayHello():
    return render_template("testangela.html")

if __name__ == "__main__":
    app.run(debug=True)