package resources;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * {@code FechaUtil}, contiene metodos genericos para manejo de fechas
 *
 * @author jpjimenez
 * @version 1.0
 */
public class FechaUtil {

    private static final Logger LOG = Logger.getLogger(FechaUtil.class);
    private static final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
    private static final String TIME12HOURS_PATTERN = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";
    private static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    private static final String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
    public static final String YYYYMMDD_HH24MMSS = "yyyyMMdd-HHmmss";
    public static final String YYYYMMDD_HH24MMSS_CON_SEPARADOR = "yyyy/MM/dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH24MMSS_CON_SEPARADOR = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDD_CON_SEPARADOR = "yyyy/MM/dd";
    public static final String DDMMYYYY_HH24MMSS = "ddMMyyyy-HHmmss";
    public static final String DDMMYYYY_HH24MMSS_CON_SEPARADOR = "dd/MM/yyyy HH:mm:ss";
    public static final String DDMMYYYY = "ddMMyyyy";
    public static final String DDMMYYYY_CON_SEPARADOR = "dd/MM/yyyy";
    public static final String DDMMYYYY_HH24MM_CON_SEPARADOR = "dd/MM/yyyy HH:mm";
    public static final String TIME12_CON_SEPARADOR = "hh:mm";
    public static final String TIME24_CON_SEPARADOR = "HH:mm";
    
    private FechaUtil() {
        super();
    }

    /**
     * @return {@link Date}, fecha actual del sistema.
     */
    public static Date ahora() {
        return new Date();
    }

    /**
     * @return {@link Calendar}, fecha actual del sistema.
     */
    public static Calendar hoy() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(ahora());
        return calendar;
    }

    /**
     * @return {@link String}, fecha actual en el formato dd/MM/yyyy.
     */
    public static String ahoraEnCadena() {
        return convertirACadena(ahora());
    }

    /**
     * @param formato {@link String}
     * @return {@link String}, fecha actual en el formato especificado.
     */
    public static String ahoraEnCadena(String formato) {
        return convertirACadena(ahora(), formato);
    }

    /**
     * @param fecha   {@link Date}
     * @param formato {@link String}
     * @return {@link String}, Devuelve la fecha en el formato especificado.<br/>Si fecha es {@code null} devuelve "".
     */
    public static String convertirACadena(Date fecha, String formato) {
        String result = "";
        if (fecha != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            result = dateFormat.format(fecha);
        }

        return result;
    }

    /**
     * @param fecha {@link Date}
     * @return {@link String}, Devuelve la fecha en el formato dd/MM/yyyy.<br/>Si fecha es {@code null} devuelve "".
     */
    public static String convertirACadena(Date fecha) {
        return convertirACadena(fecha, DDMMYYYY_CON_SEPARADOR);
    }

    /**
     * Convierte un {@code String} en {@code Date}, segun el formato especificado
     *
     * @param fecha   {@link String}
     * @param formato {@link String}
     * @return {@link Date}, Si no se puede convertir a {@code Date} devuelve {@code null}
     */
    public static Date convertirAFecha(String fecha, String formato) {
        Date result = null;
        SimpleDateFormat format = new SimpleDateFormat(formato);

        try {
            if (fecha != null && fecha.length() > 0) {
                result = format.parse(fecha);
            }
        } catch (Exception e) {
            LOG.debug("parseFecha", e);
        }

        return result;
    }

    /**
     * Convierte un {@code String} en {@code Date}, segun el formato dd/MM/yyyy
     *
     * @param fecha {@link String}
     * @return {@link Date}, Si no se puede convertir a {@code Date} devuelve {@code null}
     */
    public static Date convertirAFecha(String fecha) {
        return convertirAFecha(fecha, DDMMYYYY_CON_SEPARADOR);
    }

    /**
     * Devuelve el anio de una fecha dada
     *
     * @return {@link int}, anio actual
     */
    public static int obtenerAnio() {
        return hoy().get(Calendar.YEAR);
    }

    /**
     * Devuelve el anio de una fecha dada
     *
     * @return {@link int}, anio actual
     */
    public static String obtenerAnioEnCadena() {
        return String.valueOf(obtenerAnio());
    }

    /**
     * Devuelve el anio de una fecha dada
     *
     * @param fecha {@link Date}
     * @return {@link int}, anio de una fecha dada
     */
    public static int obtenerAnio(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.YEAR);
    }

    /**
     * Devuelve el anio de una fecha dada en el formato especificado
     *
     * @param fecha {@link Date}
     * @return {@link String}, anio de una fecha dada
     */
    public static String obtenerAnioEnCadena(Date fecha) {
        return String.valueOf(obtenerAnio(fecha));
    }

    /**
     * Devuelve el anio de una fecha dada en el formato especificado
     *
     * @param fecha   {@link String}
     * @param formato {@link String}
     * @return {@link String}, anio de una fecha dada
     */
    public static String obtenerAnioEnCadena(String fecha, String formato) {
        return obtenerAnioEnCadena(convertirAFecha(fecha, formato));
    }

    /**
     * Devuelve el mes actual
     *
     * @return {@link int}
     */
    public static int obtenerMes() {
        return hoy().get(Calendar.MONTH) + 1;
    }

    /**
     * Devuelve el mes de una fecha dada
     *
     * @return {@link int}
     */
    public static int obtenerMes(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * Devuelve el mes actual
     *
     * @return {@link String}
     */
    public static String obtenerMesEnCadena() {
        return StringUtils.leftPad(String.valueOf(obtenerMes()), 2, '0');
    }

    /**
     * Devuelve el mes actual de una fecha dada
     *
     * @return {@link String}
     */
    public static String obtenerMesEnCadena(Date fecha) {
        return StringUtils.leftPad(String.valueOf(obtenerMes(fecha)), 2, '0');
    }

    /**
     * Devuelve el mes actual de una fecha dada en el formato especificado
     *
     * @return {@link String}
     */
    public static String obtenerMesEnCadena(String fecha, String formato) {
        return StringUtils.leftPad(String.valueOf(obtenerMes(convertirAFecha(fecha, formato))), 2, '0');
    }

    /**
     * Devuelve el dia actual
     *
     * @return {@link int}
     */
    public static int obtenerDia() {
        return hoy().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Devuelve el dia la fecha recibida
     *
     * @return {@link int}
     */
    public static int obtenerDia(Date fecha) {
    	Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(Calendar.DAY_OF_MONTH);
    }
    
    /**
     * Devuelve el dia actual
     *
     * @return {@link String}
     */
    public static String obtenerDiaEnCadena() {
        return StringUtils.rightPad(String.valueOf(obtenerDia()), 2, '0');
    }

    /**
     * Devuelve la semana del mes actual
     *
     * @return {@link int}
     */
    public static int obtenerSemana() {
        return hoy().get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * Compara dos fechas:
     *
     * @param firstDate {@link Date}
     * @param endDate   {@link Date}
     * @return {@link int}<br/>
     * Si la primera fecha es menor retorna 1 <br/>
     * Si las dos fechas son iguales retorna 0 <br/>
     * Si la segunda fecha es menor retorna -1
     */
    public static int comparar(Date firstDate, Date endDate) {
        Calendar calendar = new GregorianCalendar();

        calendar.setTime(firstDate);
        Calendar calendarFirst = new GregorianCalendar(
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE));

        calendar.setTime(endDate);
        Calendar calendarEnd = new GregorianCalendar(
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE));

        if (calendarFirst.getTime().getTime() < calendarEnd.getTime().getTime()) {
            return 1;
        } else if (calendarFirst.getTime().getTime() == calendarEnd.getTime().getTime()) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Suma un tiempo determinado a una fecha dada
     *
     * @param dateOriginal {@link Date}
     * @param type         {@link Integer}
     * @param value        {@link Integer}
     * @return {@link Date}
     */
    public static Date sumar(Date dateOriginal, Integer type, Integer value) {
        Date date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateOriginal);
        cal.add(type, value);

        date = cal.getTime();

        return date;
    }

    /**
     * Obtiene los d\u00EDas transcurridos entre dos fechas dadas
     *
     * @param fechaInicial {@link Date}
     * @param fechaFinal   {@link Date}
     * @return {@link long}
     */
    public static long restar(Date fechaInicial, Date fechaFinal) {
        return (fechaFinal.getTime() - fechaInicial.getTime()) / MILLSECS_PER_DAY;
    }

    /**
     * Obtiene el ultimo d\u00EDa del mes y anio indicado
     *
     * @param mes  {@link Number}
     * @param anho {@link Number}
     * @return {@link Date}
     */
    public static Date ultimoDiaMes(Number mes, Number anho) {
        Calendar pCal = Calendar.getInstance();
        pCal.set(GregorianCalendar.YEAR, anho.intValue());
        pCal.set(GregorianCalendar.MONTH, mes.intValue());
        pCal.set(GregorianCalendar.DATE, 1);

        return sumar(pCal.getTime(), GregorianCalendar.DATE, -1);
    }

    /**
     * Obtiene el ultimo d\u00EDa del mes seg\u00EDn la fecha indicada
     *
     * @param fecha {@link Date}
     * @return {@link Date}
     */
    public static Date ultimoDiaMes(Date fecha) {
        Calendar pCal = Calendar.getInstance();
        pCal.set(GregorianCalendar.YEAR, obtenerAnio(fecha));
        pCal.set(GregorianCalendar.MONTH, obtenerMes(fecha));
        pCal.set(GregorianCalendar.DATE, 1);

        return sumar(pCal.getTime(), GregorianCalendar.DATE, -1);
    }

    /**
     * Valida si una cadena tiene el formato de hh:mm am/pm
     *
     * @param time {@link String}, cadena que representa la hora
     * @return {@code true} si es un formato valido, {@code false} si es un formato invalido
     */
    public static boolean validarHoraFormato12(String time) {
        Pattern pattern = Pattern.compile(TIME12HOURS_PATTERN);
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }

    /**
     * Valida si una cadena tiene el formato de HH:mm
     *
     * @param time {@link String}, cadena que representa la hora
     * @return {@code true} si es un formato valido, {@code false} si es un formato invalido
     */
    public static boolean validarHoraFormato24(String time) {
        Pattern pattern = Pattern.compile(TIME24HOURS_PATTERN);
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }

    /**
     * Valida si una cadena tiene el formato de dd/MM/yyyy
     *
     * @param date {@link String}, cadena que representa la fecha
     * @return {@code true} si es un formato valido, {@code false} si es un formato invalido
     */
    public static boolean validar(String date) {
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
