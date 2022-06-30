import 'package:delivery_express/l10n/strings/app_localizations.dart';
import 'package:flutter/material.dart';

class BottomSheetCustom extends StatelessWidget {
  const BottomSheetCustom({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Builder(
      builder: (context) {
        return Center(
          child: IconButton(
            icon: const Icon(
              Icons.expand_less_rounded,
              color: Colors.grey,
            ),
            onPressed: () {
              showBottomSheet(
                enableDrag: true,
                context: context,
                builder: (context) {
                  return Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Wrap(
                      crossAxisAlignment: WrapCrossAlignment.center,
                      children: [
                        ListTile(
                          title: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(AppLocalizations.of(context)!.goodAfternoon),
                              const Text('Supermecado Nova Europa'),
                            ],
                          ),
                        ),
                        const Divider(),
                        SizedBox(
                          width: MediaQuery.of(context).size.width,
                          child: ElevatedButton.icon(
                            onPressed: () {},
                            icon: const Icon(Icons.unarchive_rounded),
                            label: Text(AppLocalizations.of(context)!.newDelivery.toUpperCase()),
                          ),
                        ),
                        const Divider(),
                        SizedBox(
                          width: MediaQuery.of(context).size.width,
                          child: ElevatedButton.icon(
                            icon: const Icon(Icons.description_rounded),
                            onPressed: () {},
                            label: Text(AppLocalizations.of(context)!.latestTransactions.toUpperCase()),
                          ),
                        ),
                      ],
                    ),
                  );
                },
              );
            },
          ),
        );
      },
    );
  }
}
