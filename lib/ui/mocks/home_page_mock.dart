import 'package:syncfusion_flutter_charts/charts.dart';

import '../../data/models/home/home.dart' show SalesData, TypeSale;
import '../theme/theme.dart' show AppColors;

List<SalesData> dataWeekMock = [
  SalesData('Dom', 20),
  SalesData('Seg', 10),
  SalesData('Ter', 30),
  SalesData('Qua', 10),
  SalesData('Qui', 5),
  SalesData('Sex', 25),
  SalesData('Sab', 25),
];

List<TypeSale> dataTypeSalesMock = [
  TypeSale(name: 'Alimentação', qunt: 28),
  TypeSale(name: 'Vestuário', qunt: 32),
  TypeSale(name: 'Encomenda Fragio', qunt: 20),
  TypeSale(name: 'Outros', qunt: 19),
  TypeSale(name: 'Documentos', qunt: 1),
];

List<AreaSeries<SalesData, String>> seriesAreaMock = <AreaSeries<SalesData, String>>[
  // Initialize line series.
  AreaSeries<SalesData, String>(
      color: AppColors.primaryRed.withOpacity(0.6),
      dataSource: dataWeekMock,
      xValueMapper: (SalesData sales, _) => sales.month,
      yValueMapper: (SalesData sales, _) => sales.sales)
];

List<ColumnSeries<SalesData, String>> seriesColumnMock = <ColumnSeries<SalesData, String>>[
  // Initialize line series.
  ColumnSeries<SalesData, String>(
      color: AppColors.primaryRed,
      dataSource: dataWeekMock,
      xValueMapper: (SalesData sales, _) => sales.month,
      yValueMapper: (SalesData sales, _) => sales.sales)
];

List<PieSeries<TypeSale, String>> seriesPieMock = <PieSeries<TypeSale, String>>[
  // Initialize line series.
  PieSeries<TypeSale, String>(
    legendIconType: LegendIconType.circle,
    explode: true,
    explodeAll: true,
    explodeIndex: 0,
    explodeOffset: '10%',
    dataSource: dataTypeSalesMock,
    xValueMapper: (TypeSale sales, _) => sales.name,
    yValueMapper: (TypeSale sales, _) => sales.qunt,
    dataLabelMapper: (TypeSale sale, _) => sale.name,
    startAngle: 90,
    endAngle: 90,
    dataLabelSettings: const DataLabelSettings(
      isVisible: true,
      labelIntersectAction: LabelIntersectAction.shift,
      overflowMode: OverflowMode.shift,
      useSeriesColor: true,
    ),
    enableTooltip: true,
  )
];
