import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';
import 'package:location/location.dart';

import '../../theme/theme.dart';

class HomePege extends StatefulWidget {
  const HomePege({Key? key}) : super(key: key);

  @override
  State<HomePege> createState() => _HomePegeState();
}

class _HomePegeState extends State<HomePege> {
  late GoogleMapController mapController;

  final LatLng _center = const LatLng(-20.390480088539626, -43.4946733355632);
  final Location _location = Location();
  final MapType _currentMapType = MapType.normal;

  void _onMapCreated(GoogleMapController controller) {
    mapController = controller;
    _location.onLocationChanged.listen((l) {
      mapController.animateCamera(
        CameraUpdate.newCameraPosition(
          CameraPosition(target: LatLng(l.latitude!, l.longitude!), zoom: 15),
        ),
      );
    });
  }

  void _currentLocation() async {
    final GoogleMapController controller = mapController;
    LocationData currentLocation;
    Location location = Location();

    currentLocation = await location.getLocation();

    controller.animateCamera(CameraUpdate.newCameraPosition(
      CameraPosition(
        bearing: 0,
        target: LatLng(currentLocation.latitude!, currentLocation.longitude!),
        zoom: 17.0,
      ),
    ));
  }

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
              Tab(
                text: 'Meu painel'.toUpperCase(),
              ),
              Tab(
                text: 'Mapa'.toUpperCase(),
              ),
            ],
          ),
        ),
        body: TabBarView(
          physics: const NeverScrollableScrollPhysics(),
          children: <Widget>[
            const Center(
              child: Text("Meu painel"),
            ),
            Stack(
              children: [
                GoogleMap(
                  mapType: _currentMapType,
                  onMapCreated: _onMapCreated,
                  initialCameraPosition: CameraPosition(
                    target: _center,
                    zoom: 15.0,
                  ),
                  scrollGesturesEnabled: true,
                  zoomControlsEnabled: false,
                  myLocationButtonEnabled: false,
                  myLocationEnabled: true,
                ),
                MyLocationButtonCusttom(currentLocation: _currentLocation),
              ],
            ),
          ],
        ),
        drawer: drawer(),
      ),
    );
  }

  Drawer drawer() {
    return Drawer(
      child: ListView(
        padding: EdgeInsets.zero,
        children: [
          DrawerHeader(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              mainAxisAlignment: MainAxisAlignment.end,
              children: const [
                CircleAvatar(
                  backgroundColor: AppColors.primaryRed,
                  child: Icon(
                    Icons.person,
                    size: 40,
                    color: Colors.white,
                  ),
                  radius: 35,
                ),
                Text('Maria Aparecida'),
                Text('Caloi Montana MB 26'),
              ],
            ),
          ),
          ListTile(
            leading: const Icon(Icons.home_rounded),
            title: const Text('Início'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.list_alt_rounded),
            title: const Text('Transações Concluídas'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.payments_rounded),
            title: const Text('Extrato completo'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.settings_rounded),
            title: const Text('Configurações da conta'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.help_rounded),
            title: const Text('Ajuda e Suporte'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.info_rounded),
            title: const Text('Sobre'),
            onTap: () {},
          ),
          ListTile(
            leading: const Icon(Icons.exit_to_app_rounded),
            title: const Text('Sair'),
            onTap: () {},
          ),
        ],
      ),
    );
  }
}

class MyLocationButtonCusttom extends StatelessWidget {
  final Function() currentLocation;

  const MyLocationButtonCusttom({
    Key? key,
    required this.currentLocation,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Align(
        alignment: Alignment.bottomRight,
        child: FloatingActionButton(
          onPressed: currentLocation,
          child: const Icon(Icons.my_location_rounded),
          tooltip: 'My Location',
        ),
      ),
    );
  }
}
