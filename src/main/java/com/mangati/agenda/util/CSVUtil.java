
 package com.mangati.agenda.util;
   
    import com.mangati.agenda.dto.AgendamentoDTO;
    import com.opencsv.CSVWriter;
    import com.opencsv.bean.StatefulBeanToCsv;
    import com.opencsv.bean.StatefulBeanToCsvBuilder;
    import com.opencsv.exceptions.CsvDataTypeMismatchException;
    import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
   
   import java.io.ByteArrayOutputStream;
   import java.io.OutputStreamWriter;
   import java.io.Writer;
   import java.nio.charset.StandardCharsets;
   import java.util.List;
  
   /**
    * Utility class for converting AgendamentoDTO objects to CSV format.
    */
   public class CSVUtil {
  
       /**
        * Converts a list of AgendamentoDTO objects to CSV byte array.
        *
        * @param agendamentos List of AgendamentoDTO objects to convert
        * @return CSV data as byte array
        * @throws Exception if CSV conversion fails
        */
       public static byte[] agendamentosToCSV(List<AgendamentoDTO> agendamentos) throws Exception {
           ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
           Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
  
           try {
               // Configure CSV writer with proper formatting
               StatefulBeanToCsvBuilder<AgendamentoDTO> builder = new StatefulBeanToCsvBuilder<>(writer)
                       .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                       .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                       .withApplyQuotesToAll(false)
                       .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                       .withLineEnd(CSVWriter.DEFAULT_LINE_END);
  
               StatefulBeanToCsv<AgendamentoDTO> beanToCsv = builder.build();
  
               // Write the data to CSV
               beanToCsv.write(agendamentos);
  
               writer.flush();
               return outputStream.toByteArray();
           } finally {
               writer.close();
           }
       }
  
       /**
        * Returns the CSV headers for AgendamentoDTO objects.
        * This can be used to manually construct CSV if needed.
        *
        * @return CSV header string
        */
       public static String getAgendamentoCSVHeaders() {
           return "ID,Service ID,Start Time,End Time,Patient Name,Patient Phone,Patient Email,Observations,Status";
       }
   }

