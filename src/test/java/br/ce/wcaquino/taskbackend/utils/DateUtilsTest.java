package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {
	
	@Test
	public void deveRetornarTrueParaDatasFuturas() {
		LocalDate date = LocalDate.of(2030, 01, 01);
		boolean resultado = DateUtils.isEqualOrFutureDate(date);
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void deveRetornarFalseParaDatasPassadas() {
		LocalDate date = LocalDate.of(2010, 01, 01);
		boolean resultado = DateUtils.isEqualOrFutureDate(date);
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void deveRetornarTrueParaDataAtual() {
		LocalDate date = LocalDate.now();
		boolean resultado = DateUtils.isEqualOrFutureDate(date);
		Assert.assertTrue(resultado);
	}
}
