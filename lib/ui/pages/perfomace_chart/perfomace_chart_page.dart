import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:syncfusion_flutter_charts/charts.dart';

import '../../mocks/mocks.dart';
import '../../theme/theme.dart';

class PerfomaceChartPage extends StatelessWidget {
  const PerfomaceChartPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      initialIndex: 0,
      length: 2,
      child: Scaffold(
        appBar: AppBar(
          title: const Expanded(child: Text('Gráficos de Desempenho')),
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
              Tab(text: 'Entragas Semanais'.toUpperCase()),
              Tab(text: 'Entragas por Tipo'.toUpperCase()),
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
              text: 'Resumo da Semana',
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

class TotalBalanceTile extends StatelessWidget {
  const TotalBalanceTile({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const Divider(),
        Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: const [
            Text(
              'Saldo Total',
              style: TextStyle(
                fontWeight: FontWeight.bold,
              ),
            ),
            Text('R\$ 99,00'),
          ],
        ),
      ],
    );
  }
}

class PurchaseInfoTile extends StatelessWidget {
  const PurchaseInfoTile({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const Divider(),
        Row(
          children: [
            SvgPicture.asset('lib/ui/assets/images/svg/food.svg'),
            const VerticalDivider(),
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: const [
                Text(
                  'Supermecado Nova Europa',
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    letterSpacing: .1,
                  ),
                ),
                Text('R\$48,00'),
              ],
            ),
            const VerticalDivider(),
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.end,
                children: const [
                  Text(
                    '26 jan 2020',
                    style: TextStyle(fontSize: 12),
                  ),
                  Text(
                    '10:34',
                    style: TextStyle(fontSize: 12),
                  ),
                ],
              ),
            ),
          ],
        ),
      ],
    );
  }
}
