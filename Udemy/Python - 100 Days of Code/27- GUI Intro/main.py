import _tkinter

window = _tkinter.Tk()
window.minsize(width=500, height=300)

window.title("My GUI")

myLabel = _tkinter.Label(text="I am a label")
myLabel.pack()

window.mainloop()