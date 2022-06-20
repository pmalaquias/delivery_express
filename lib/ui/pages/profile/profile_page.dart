import 'package:flutter/material.dart';

import '../../theme/app_colors.dart';

class ProfilePage extends StatefulWidget {
  const ProfilePage({Key? key}) : super(key: key);

  @override
  _ProfilePageState createState() => _ProfilePageState();
}

class _ProfilePageState extends State<ProfilePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Meu Perfil'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: const [
            CircleAvatar(
              backgroundColor: AppColors.primaryRed,
              child: Icon(
                Icons.person,
                size: 60,
                color: Colors.white,
              ),
              radius: 60,
            ),
            SizedBox(height: 8),
            Text('100% de avaliações positivas'),
            SizedBox(height: 8),
            Text(
              'Maria Aparecida',
              style: TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 24,
              ),
            ),
            SizedBox(height: 8),
            Text(
              'Caloi Montana MB 26',
              style: TextStyle(fontSize: 16),
            ),
          ],
        ),
      ),
    );
  }
}
