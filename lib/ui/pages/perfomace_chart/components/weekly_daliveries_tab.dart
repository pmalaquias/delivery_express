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
  String dropdownValue = '1';
  @override
  Widget build(BuildContext context) {
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
                      print("valor: $newValue");
                      setState(() {
                        dropdownValue = newValue!;
                        print(dropdownValue);
                      });
                    },
                    items: <String>['1', '2'].map<DropdownMenuItem<String>>((String value) {
                      return DropdownMenuItem<String>(
                        value: value,
                        child: value == '1'
                            ? Text(AppLocalizations.of(context)!.lineChart.toUpperCase())
                            : Text(AppLocalizations.of(context)!.columnChart.toUpperCase()),
                      );
                    }).toList(),
                  ),
                ],
              )
            ],
          ),
          dropdownValue == '1'
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
