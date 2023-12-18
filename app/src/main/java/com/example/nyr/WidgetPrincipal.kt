package com.example.nyr

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class WidgetPrincipal:AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // No se requiere implementación para este ejemplo
    }

    companion object {

        // ACTUALIZAR (RECORDATORIO)...

        fun UPRec(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetId: Int,
            widgetText: String
        ) {
            val views = RemoteViews(context.packageName, R.layout.widget_vista)
            views.setTextViewText(R.id.Mensaje, widgetText)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }

        // ACTUALIZAR (NOTA)...

        fun UPNota(
            context: Context,
            appWidgetManager: AppWidgetManager,
            appWidgetId: Int,
            widgetText: String,
            backgroundColor: Int
        ) {
            val views = RemoteViews(context.packageName, R.layout.widget_vista)
            views.setTextViewText(R.id.Mensaje, widgetText)
            views.setInt(R.id.frmWidget, "setBackgroundColor", backgroundColor) // La cadena debe ser setBackgroundColor y no "setBackgroundColor"
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }

    }
}