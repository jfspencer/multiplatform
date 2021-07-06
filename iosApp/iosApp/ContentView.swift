import SwiftUI
import core

struct ContentView: View {
	let greet = Greeting().commonGreeting() //.greeting()

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}