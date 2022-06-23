import 'package:flutter/material.dart';

import '../../theme/theme.dart' show AppColors;
import 'components/components.dart';

class HomePege extends StatefulWidget {
  const HomePege({Key? key}) : super(key: key);

  @override
  State<HomePege> createState() => _HomePegeState();
}

class _HomePegeState extends State<HomePege> {
  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      initialIndex: 0,
      length: 2,
      child: Scaffold(
        appBar: AppBar(
          //automaticallyImplyLeading: false,
          title: const Text(
            'Início',
          ),
          actions: [
            IconButton(
              onPressed: () {},
              icon: const Icon(Icons.notifications_rounded),
            ),
          ],
          bottom: TabBar(
            isScrollable: false,
            labelColor: AppColors.primaryRed,
            indicatorColor: AppColors.primaryRed,
            unselectedLabelColor: AppColors.black,
            tabs: [
              Tab(text: 'Meu painel'.toUpperCase()),
              Tab(text: 'Mapa'.toUpperCase()),
            ],
          ),
        ),
        drawer: const CustomDrawer(),
        body: TabBarView(
          physics: const NeverScrollableScrollPhysics(),
          children: <Widget>[
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: SingleChildScrollView(
                child: Column(
                  children: const [
                    Header(),
                    SizedBox(height: 8),
                    InfoCard(),
                    SizedBox(height: 16),
                    AreaChart(),
                    PerfomaceChartButton(),
                  ],
                ),
              ),
            ),
            Map(),
          ],
        ),
      ),
    );
  }
}
