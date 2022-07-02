import 'package:flutter/material.dart';

import '../../extension/extension.dart';
import '../../theme/theme.dart' show AppColors;
import 'components/components.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      initialIndex: 0,
      length: 2,
      child: Scaffold(
        appBar: AppBar(
          title: Text(context.loc.home),
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
              Tab(text: context.loc.myPanel.toUpperCase()),
              Tab(text: context.loc.map.toUpperCase()),
            ],
          ),
        ),
        drawer: const CustomDrawerDeliveryMan(),
        body: TabBarView(
          physics: const NeverScrollableScrollPhysics(),
          children: <Widget>[
            Padding(
              padding: const EdgeInsets.only(top: 16, left: 16, right: 16),
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

class HomeClientPage extends StatelessWidget {
  const HomeClientPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(context.loc.home),
        actions: [
          IconButton(
            onPressed: () {},
            icon: const Icon(Icons.notifications_rounded),
          ),
        ],
      ),
      drawer: const CustomDrawerClient(),
      body: Column(
        children: [
          Expanded(child: Map()),
          const BottomSheetCustom(),
        ],
      ),
    );
  }
}
