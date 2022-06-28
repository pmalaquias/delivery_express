import 'package:delivery_express/ui/pages/profile/profile.dart';
import 'package:flutter/material.dart';

import '../../../theme/theme.dart' show AppColors;
import '../../pages.dart';

class CustomDrawer extends StatelessWidget {
  const CustomDrawer({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: [
          DrawerHeader(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisAlignment: MainAxisAlignment.end,
              children: const [
                CircleAvatar(
                  backgroundColor: AppColors.primaryRed,
                  child: Icon(
                    Icons.person,
                    size: 40,
                    color: Colors.white,
                  ),
                  radius: 35,
                ),
                Text('Maria Aparecida'),
                Text('Caloi Montana MB 26'),
              ],
            ),
          ),
          ListTile(
            leading: const Icon(Icons.home_rounded),
            title: const Text('Início'),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => const HomePage(),
                ),
              );
            },
          ),
          ListTile(
            leading: const Icon(Icons.person_rounded),
            title: const Text('Perfil'),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => const ProfilePage(),
                ),
              );
            },
          ),
          ListTile(
            leading: const Icon(Icons.list_alt_rounded),
            title: const Text('Transações Concluídas'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.payments_rounded),
            title: const Text('Extrato completo'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.settings_rounded),
            title: const Text('Configurações da conta'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.help_rounded),
            title: const Text('Ajuda e Suporte'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.info_rounded),
            title: const Text('Sobre'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.exit_to_app_rounded),
            title: const Text('Sair'),
            onTap: () {},
          ),
        ],
      ),
    );
  }
}
