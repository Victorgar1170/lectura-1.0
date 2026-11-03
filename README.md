# Lectura 1.0 - App de Lectura

## Instrucciones para Android Studio

### ⚠️ IMPORTANTE: Configurar JDK en Android Studio
Este proyecto requiere JDK 17. Sigue estos pasos:

1. En Android Studio, ve a **File** → **Settings** (o Android Studio → Settings en Mac)
2. Navega a **Build, Execution, Deployment** → **Build Tools** → **Gradle**
3. En la sección "Gradle JDK", selecciona:
   - **"jbr-17"** o **"Embedded JDK"** (recomendado)
   - Si no aparece, selecciona "Download JDK" y elige versión 17
4. Haz clic en **Apply** y **OK**
5. Cierra y vuelve a abrir el proyecto

### Abrir el proyecto
1. Abre Android Studio
2. Selecciona "File" -> "Open"
3. Navega a la carpeta: `C:\Users\victo\Downloads\app lectura 1.0`
4. Selecciona la carpeta y haz clic en "OK"
5. Espera a que Gradle sincronice el proyecto (puede tomar unos minutos)

### Ejecutar pruebas unitarias
1. Una vez sincronizado el proyecto, expande el panel de "Project" (izquierda)
2. Navega a: `app` -> `src` -> `test` -> `java` -> `com.example.lectura`
3. Haz clic derecho en `ArticleViewModelTest.kt`
4. Selecciona "Run 'ArticleViewModelTest'"
5. Las pruebas deberían ejecutarse y mostrarse en verde si pasan
6. **TOMA CAPTURA DE PANTALLA** cuando las pruebas aparezcan en verde

### Generar APK Release
1. En el menú superior, selecciona "Build" -> "Generate Signed Bundle / APK"
2. Selecciona "APK" y haz clic en "Next"
3. Llena los campos con los datos del keystore:
   - Key store path: `app/mock_release_key.jks`
   - Key store password: `mock_store_123`
   - Key alias: `mock_alias`
   - Key password: `mock_key_123`
4. Haz clic en "Next"
5. Selecciona "release" como build variant
6. Haz clic en "Finish"
7. El APK se generará en: `app/build/outputs/apk/release/app-release.apk`

### Estructura del proyecto
- `app/src/main/java/com/example/lectura/` - Código fuente principal
- `app/src/test/java/com/example/lectura/` - Pruebas unitarias
- `app/mock_release_key.jks` - Keystore para firma del APK (ya existe)
- `app/build.gradle` - Configuración de build del módulo app
- `build.gradle` - Configuración de build del proyecto
- `gradle.properties` - Propiedades de Gradle
- `RELEASE_NOTES.docx` - Documento de release notes

### Notas
- El proyecto usa Android Gradle Plugin 8.1.4
- Requiere JDK 17 (Android Studio incluye JDK 17 por defecto)
- El APK de release estará ofuscado con R8
- Las pruebas unitarias usan JUnit 4
- Compile SDK: 34, Min SDK: 24
