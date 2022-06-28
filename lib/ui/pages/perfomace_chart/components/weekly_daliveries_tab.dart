import 'package:flutter/material.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

import '../../../mocks/mocks.dart' show seriesAreaMock, seriesColumnMock;
import 'components.dart' show PurchaseInfoTile, TotalBalanceTile;

class WeeklyDeliveriesTab extends StatefulWidget {
  const WeeklyDeliveriesTab({Key? key}) : super(key: key);

  @override
  State<WeeklyDeliveriesTab> createState() => _WeeklyDeliveriesTabState();
}

class _WeeklyDeliveriesTabState extends State<WeeklyDeliveriesTab> {
  String dropdownValue = 'GRÁFICO DE LINHAS';
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
                  const Text('Visualização'),
                  DropdownButton<String>(
                    value: dropdownValue,
                    elevation: 16,
                    onChanged: (String? newValue) {
                      setState(() {
                        dropdownValue = newValue!;
                      });
                    },
                    items: <String>['GRÁFICO DE LINHAS', 'GRÁFICO DE COLUNAS']
                        .map<DropdownMenuItem<String>>((String value) {
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
          dropdownValue == 'GRÁFICO DE LINHAS'
              ? SfCartesianChart(
                  title: ChartTitle(
                    text: 'Resumo da Semana',
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
                    text: 'Resumo da Semana',
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
