import 'package:flutter/material.dart';

import '../../../l10n/strings/app_localizations.dart' show AppLocalizations;
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
          //automaticallyImplyLeading: false,
          title: Text(AppLocalizations.of(context)!.home),
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
              Tab(text: AppLocalizations.of(context)!.myPanel.toUpperCase()),
              Tab(text: AppLocalizations.of(context)!.map.toUpperCase()),
            ],
          ),
        ),
        drawer: const CustomDrawer(),
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
