import 'package:flutter/material.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

import '../../../../l10n/strings/app_localizations.dart' show AppLocalizations;
import '../../../mocks/mocks.dart' show seriesAreaMock, seriesColumnMock;
import 'components.dart' show PurchaseInfoTile, TotalBalanceTile;

class WeeklyDeliveriesTab extends StatefulWidget {
  const WeeklyDeliveriesTab({Key? key}) : super(key: key);

  @override
  State<WeeklyDeliveriesTab> createState() => _WeeklyDeliveriesTabState();
}

class _WeeklyDeliveriesTabState extends State<WeeklyDeliveriesTab> {
  @override
  Widget build(BuildContext context) {
    String dropdownValue = AppLocalizations.of(context)!.lineChart.toUpperCase();
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.end,
            children: [
              Column(
                crossAxisAlignment: CrossAxisAlignment.end,
                children: [
                  Text(AppLocalizations.of(context)!.visualization),
                  DropdownButton<String>(
                    value: dropdownValue,
                    elevation: 16,
                    onChanged: (String? newValue) {
                      setState(() {
                        dropdownValue = newValue!;
                      });
                    },
                    items: <String>[
                      AppLocalizations.of(context)!.lineChart.toUpperCase(),
                      AppLocalizations.of(context)!.columnChart.toUpperCase()
                    ].map<DropdownMenuItem<String>>((String value) {
                      return DropdownMenuItem<String>(
                        value: value,
                        child: Text(value),
                      );
                    }).toList(),
                  ),
                ],
              )
            ],
          ),
          dropdownValue == AppLocalizations.of(context)!.lineChart
              ? SfCartesianChart(
                  title: ChartTitle(
                    text: AppLocalizations.of(context)!.weekSummary,
                    alignment: ChartAlignment.near,
                  ),

                  primaryXAxis: CategoryAxis(
                    labelPlacement: LabelPlacement.onTicks,
                    majorGridLines: const MajorGridLines(width: 0),
                  ), // Initialize category axis.
                  tooltipBehavior: TooltipBehavior(
                    enable: true,
                    header: '',
                  ),
                  series: seriesAreaMock,
                )
              : SfCartesianChart(
                  title: ChartTitle(
                    text: AppLocalizations.of(context)!.weekSummary,
                    alignment: ChartAlignment.near,
                  ),
                  primaryXAxis: CategoryAxis(
                    labelPlacement: LabelPlacement.betweenTicks,
                    majorGridLines: const MajorGridLines(width: 0),
                  ),
                  series: seriesColumnMock,
                ),
          const PurchaseInfoTile(),
          const PurchaseInfoTile(),
          const PurchaseInfoTile(),
          const TotalBalanceTile(),
        ],
      ),
    );
  }
}
