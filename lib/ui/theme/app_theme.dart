import 'package:flutter/material.dart';

mixin AppColors {
  static const Color black = Color(0xFF262626);
  static const Color grey1 = Color(0xFF4C4C4C);
  static const Color grey2 = Color(0xFFB1B1B1);
  static const Color grey3 = Color(0xFFF3F3F3);
  static const Color lightPurple = Color(0xFFF3F0F5);
  static const Color purple = Color(0xFF712369);
  static const Color heavyPurple = Color(0xFF4E1C51);
  static const Color extraHeavyPurple = Color(0xFF25083E);
  static const Color seccondRed = Color(0xFF7F0000);
  //static const Color pink = Color(0xFFFFB0CF);
  static const Color primaryRed = Color(0xFFB71C1C);
  static const Color danger = Color(0xFFF26F66);
  static const Color flatOrange = Color(0xFFFF8C64);
  //static const Color flatYellow = Color(0xFFE5B022);
  static const Color success = Color(0xFF3DC14E);
  static const Color flatBlue = Color(0xFF66C7F2);
  static const Color background = Color(0xFFFFFFFF);
}

mixin AppTextTheme {
  static const TextTheme montserratTextTheme = TextTheme(
    headline1: TextStyle(
      fontSize: 97,
      fontWeight: FontWeight.w300,
      fontFamily: 'Montserrat',
      letterSpacing: -1.5,
    ),
    headline2: TextStyle(
      fontSize: 61,
      fontWeight: FontWeight.w300,
      fontFamily: 'Montserrat',
      letterSpacing: -0.5,
    ),
    headline3: TextStyle(
      fontSize: 48,
      fontWeight: FontWeight.w400,
      fontFamily: 'Montserrat',
    ),
    headline4: TextStyle(
      fontSize: 34,
      fontWeight: FontWeight.w400,
      fontFamily: 'Montserrat',
      letterSpacing: 0.25,
    ),
    headline5: TextStyle(
      fontSize: 24,
      fontWeight: FontWeight.w400,
      fontFamily: 'Montserrat',
    ),
    headline6: TextStyle(
      fontSize: 20,
      fontWeight: FontWeight.w500,
      fontFamily: 'Montserrat',
      letterSpacing: 0.15,
    ),
    subtitle1: TextStyle(
      fontSize: 16,
      fontWeight: FontWeight.w400,
      fontFamily: 'Montserrat',
      letterSpacing: 0.15,
    ),
    subtitle2: TextStyle(
      fontSize: 14,
      fontWeight: FontWeight.w500,
      fontFamily: 'Montserrat',
      letterSpacing: 0.1,
    ),
    bodyText1: TextStyle(
      fontSize: 16,
      fontWeight: FontWeight.w400,
      fontFamily: 'Montserrat',
      letterSpacing: 0.5,
    ),
    bodyText2: TextStyle(
      fontSize: 14,
      fontWeight: FontWeight.w400,
      fontFamily: 'Montserrat',
      letterSpacing: 0.25,
    ),
    button: TextStyle(
      fontSize: 14,
      fontWeight: FontWeight.w500,
      fontFamily: 'Montserrat',
      letterSpacing: 1.25,
    ),
    caption: TextStyle(
      fontSize: 12,
      fontWeight: FontWeight.w400,
      fontFamily: 'Montserrat',
      letterSpacing: 0.4,
    ),
    overline: TextStyle(
      fontSize: 10,
      fontWeight: FontWeight.w400,
      fontFamily: 'Montserrat',
      letterSpacing: 1.5,
    ),
  );
}

mixin AppTheme {
  static const Color _lightFillColor = AppColors.black;
  static const Color _darkFillColor = AppColors.background;

  static final Color _lightFocusColor = _lightFillColor.withOpacity(0.12);
  static final Color _darkFocusColor = _darkFillColor.withOpacity(0.12);

  static ThemeData lightThemeData = themeData(lightColorScheme, _lightFocusColor);
  static ThemeData darkThemeData = themeData(darkColorScheme, _darkFocusColor);

  static ThemeData themeData(final ColorScheme colorScheme, final Color focusColor) => ThemeData(
        canvasColor: colorScheme.background,
        colorScheme: colorScheme,
        disabledColor: colorScheme.onBackground.withAlpha(40),
        dividerColor: colorScheme.onBackground.withAlpha(40),
        elevatedButtonTheme: elevatedButtonThemeData(colorScheme),
        errorColor: colorScheme.error,
        focusColor: focusColor,
        fontFamily: 'Montserrat',
        highlightColor: Colors.transparent,
        iconTheme: IconThemeData(color: colorScheme.onPrimary),
        inputDecorationTheme: inputDecorationTheme(colorScheme),
        primaryColor: colorScheme.primary,
        primaryColorLight: colorScheme.primaryContainer,
        scaffoldBackgroundColor: colorScheme.background,
        textTheme: AppTextTheme.montserratTextTheme,
      );

  static const ColorScheme lightColorScheme = ColorScheme(
    background: AppColors.background,
    brightness: Brightness.light,
    error: AppColors.danger,
    onBackground: AppColors.black,
    onError: AppColors.background,
    onPrimary: AppColors.background,
    onSecondary: AppColors.background,
    onSurface: AppColors.black,
    primary: AppColors.primaryRed,
    secondary: AppColors.purple,
    surface: AppColors.background,
  );

  static const ColorScheme darkColorScheme = ColorScheme(
    background: AppColors.black,
    brightness: Brightness.dark,
    error: AppColors.danger,
    onBackground: AppColors.background,
    onError: AppColors.black,
    onPrimary: AppColors.black,
    onSecondary: AppColors.black,
    onSurface: AppColors.background,
    primary: AppColors.primaryRed,
    secondary: AppColors.purple,
    surface: AppColors.black,
  );

  static ElevatedButtonThemeData elevatedButtonThemeData(final ColorScheme colorScheme) => ElevatedButtonThemeData(
        style: ElevatedButton.styleFrom(
          elevation: 0,
          onPrimary: colorScheme.onPrimary,
          onSurface: colorScheme.onSurface,
          padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 32),
          primary: colorScheme.primary,
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(8)),
          textStyle: AppTextTheme.montserratTextTheme.subtitle1?.copyWith(color: colorScheme.onPrimary),
        ),
      );

  static InputDecorationTheme inputDecorationTheme(final ColorScheme colorScheme) => InputDecorationTheme(
        /* enabledBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
          borderSide: BorderSide(
            color: colorScheme.onBackground.withAlpha(80),
          ),
        ), */
        errorBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
          borderSide: BorderSide(
            color: colorScheme.error,
          ),
        ),
        /* focusedBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
          borderSide: BorderSide(
            color: colorScheme.onBackground.withAlpha(200),
          ),
        ), */
        disabledBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
          borderSide: BorderSide(
            color: colorScheme.onBackground.withAlpha(40),
          ),
        ),
        focusedErrorBorder: OutlineInputBorder(
          borderRadius: BorderRadius.circular(8),
          borderSide: BorderSide(
            color: colorScheme.error,
          ),
        ),
        labelStyle: AppTextTheme.montserratTextTheme.bodyText1,
        hintStyle: AppTextTheme.montserratTextTheme.subtitle1?.copyWith(
          color: colorScheme.onBackground.withAlpha(40),
        ),
      );
}
