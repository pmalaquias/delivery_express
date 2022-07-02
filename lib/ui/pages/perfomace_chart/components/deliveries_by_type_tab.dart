import 'package:flutter/material.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

import '../../../extension/extension.dart';
import '../../../mocks/mocks.dart' show seriesPieMock;
import 'components.dart' show PurchaseInfoTile, TotalBalanceTile;

class DeliveriesByTypeTab extends StatelessWidget {
  DeliveriesByTypeTab({Key? key}) : super(key: key);

  List<Color> paletteColor = [
    const Color(0xFFD9D7CD),
    const Color(0xFF8A1820),
    const Color(0xFFB0040D),
    const Color(0xFF2E2E2F),
    const Color(0xFF999D8E),
  ];

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          SfCircularChart(
            borderWidth: .01,
            tooltipBehavior: TooltipBehavior(enable: true),
            palette: paletteColor,
            title: ChartTitle(
              text: context.loc.weekSummary,
              alignment: ChartAlignment.near,
            ),
            series: seriesPieMock,
            legend: Legend(
              //height: '10%',
              overflowMode: LegendItemOverflowMode.wrap,
              isVisible: true,
              isResponsive: true,
              toggleSeriesVisibility: true,
              position: LegendPosition.bottom,
            ),
          ),
          Column(
            children: const [
              PurchaseInfoTile(),
              PurchaseInfoTile(),
              PurchaseInfoTile(),
              TotalBalanceTile(),
            ],
          ),
        ],
      ),
    );
  }
}
