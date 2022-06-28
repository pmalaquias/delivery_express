import 'package:flutter/material.dart';

import '../../../l10n/strings/app_localizations.dart' show AppLocalizations;
import '../../theme/theme.dart' show AppColors;
import 'components/components.dart' show DeliveriesByTypeTab, WeeklyDeliveriesTab;

class PerfomaceChartPage extends StatelessWidget {
  const PerfomaceChartPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      initialIndex: 0,
      length: 2,
      child: Scaffold(
        appBar: AppBar(
          title: Expanded(child: Text(AppLocalizations.of(context)!.perfomaceChartTitle)),
          actions: [
            IconButton(
              onPressed: () {},
              icon: const Icon(Icons.search_rounded),
            ),
          ],
          bottom: TabBar(
            isScrollable: true,
            labelColor: AppColors.primaryRed,
            indicatorColor: AppColors.primaryRed,
            unselectedLabelColor: AppColors.black,
            tabs: [
              Tab(text: AppLocalizations.of(context)!.weeklyDeliveriesTitle.toUpperCase()),
              Tab(text: AppLocalizations.of(context)!.deliveriesByTypeTitle.toUpperCase()),
            ],
          ),
        ),
        body: TabBarView(
          physics: const NeverScrollableScrollPhysics(),
          children: <Widget>[
            const WeeklyDeliveriesTab(),
            DeliveriesByTypeTab(),
          ],
        ),
      ),
    );
  }
}
