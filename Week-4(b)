import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: HomeScreen(),
  ));
}

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Home Screen'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => NewScreen(),
              ),
            );
          },
          child: Text('Go to New Screen'),
        ),
      ),
    );
  }
}

class NewScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('New Screen'),
      ),
      body: Center(
        child: Text(
          'This is a New Screen',
          style: TextStyle(fontSize: 24),
        ),
      ),
    );
  }
}
