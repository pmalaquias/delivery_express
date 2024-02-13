import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../../../extension/extension.dart';
import '../../../theme/theme.dart' show AppColors;
import '../../pages.dart';

class CustomDrawerDeliveryMan extends StatelessWidget {
  const CustomDrawerDeliveryMan({Key? key}) : super(key: key);

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
            title: Text(context.loc.home),
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
            title: Text(context.loc.drawerProfile),
            onTap: () {
              Get.toNamed('/profile');
            },
          ),
          ListTile(
            leading: const Icon(Icons.list_alt_rounded),
            title: Text(context.loc.drawerCompletedTransactions),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.payments_rounded),
            title: Text(context.loc.drawerCompleteExtract),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.settings_rounded),
            title: Text(context.loc.drawerAccountConfigurations),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.help_rounded),
            title: Text(context.loc.drawerHelpAndSupport),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.info_rounded),
            title: Text(context.loc.drawerAbout),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.exit_to_app_rounded),
            title: Text(context.loc.drawerExit),
            onTap: () {
              Get.offAllNamed('/auth');
            },
          ),
        ],
      ),
    );
  }
}

class CustomDrawerClient extends StatelessWidget {
  const CustomDrawerClient({
    Key? key,
  }) : super(key: key);

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
                    Icons.store_rounded,
                    size: 40,
                    color: Colors.white,
                  ),
                  radius: 35,
                ),
                Text('Supermecado Nova Europa'),
                Text('Av. JK, Ouro Preto - MG'),
              ],
            ),
          ),
          ListTile(
            leading: const Icon(Icons.home_rounded),
            title: Text(context.loc.home),
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
            title: Text(context.loc.drawerProfile),
            onTap: () {
              Get.toNamed('/profile');
            },
          ),
          ListTile(
            leading: const Icon(Icons.swap_calls_rounded),
            title: Text(context.loc.drawerDeliveriesInProgress),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.list_alt_rounded),
            title: Text(context.loc.drawerCompletedTransactions),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.settings_rounded),
            title: Text(context.loc.drawerAccountConfigurations),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.help_rounded),
            title: Text(context.loc.drawerHelpAndSupport),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.info_rounded),
            title: Text(context.loc.drawerAbout),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.exit_to_app_rounded),
            title: Text(context.loc.drawerExit),
            onTap: () {
              Get.offAllNamed('/auth');
            },
          ),
        ],
      ),
    );
  }
}
