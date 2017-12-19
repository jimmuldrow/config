

def d = "Hi"
println d
d = 7
println d

d = '''Multi lines made easy with either 
single or double quotes, as long as there
are three of them.'''
println d

d = /ALmost anything !@#$%^&*()_\/'":; goes between slashes/
println d

def user = new Expando(name: 'mrhaki', email: 'mail@email.com')
println "this is ${user.name}'s name."


// as def in trait are key words