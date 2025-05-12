package com.ssanai.jumplearn.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class CommonDateUtil {
	public CommonDateUtil() {}
	
	// LocalDate타입 --> Date타입으로 변환
	public Date toDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
	//String 타입 --> Date 타입으로 변환
	public Date toDate2(String date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

	// LocalDateTime --> DateTime 으로 변환
	public Date toDateTime(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	// Date 타입 --> LocalDate 로 변환
	public LocalDate toLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	// Date 타입 --> LocalDateTime 으로 변환
	public LocalDateTime toLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	// Date 타입 --> LocalDateTime 문자열로 변환
	public String dateTolocalDateTimeString(Date date) {
		return this.toLocalDateTime(date).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	// LocalDateTime 타입 --> LocalDateTime 문자열로 변환
	public String localDateTimeToString(LocalDateTime localDateTime) {
		return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

	// LocalDateTime 타입 --> LocalDateTime 문자열로 변환
	public String localDateTimeToString(LocalDateTime dateValue, String pattern) {
		return dateValue.format(DateTimeFormatter.ofPattern(pattern));
	}
	public String dateToString(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
}