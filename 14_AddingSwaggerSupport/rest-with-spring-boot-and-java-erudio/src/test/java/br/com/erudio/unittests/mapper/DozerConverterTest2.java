package br.com.erudio.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.unittests.mapper.mocks.MockBook;

public class DozerConverterTest2 {
    
    MockBook inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockBook();
    }

    @Test
    public void parseEntityToVOTest() {
        BookVO output = DozerMapper.parseObject(inputObject.mockEntity(), BookVO.class);
        assertEquals(Long.valueOf(0L), output.getKey());
        assertEquals("Some Author0", output.getAuthor());
        assertEquals("Some Title0", output.getTitle());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookVO> outputList = DozerMapper.parseListObjects(inputObject.mockEntityList(), BookVO.class);
        BookVO outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getKey());
        assertEquals("Some Author0", outputZero.getAuthor());
        assertEquals("Some Title0", outputZero.getTitle());
        
        BookVO outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getKey());
        assertEquals("Some Author7", outputSeven.getAuthor());
        assertEquals("Some Title7", outputSeven.getTitle());
        
    }
/*
    @Test
    public void parseVOToEntityTest() {
        Book output = DozerMapper.parseObject(inputObject.mockVO(), Book.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Author Name Test0", output.getAuthor());
        assertEquals("Launch Date Test0", output.getLaunchDate());
        assertEquals("Price Test0", output.getPrice());
        assertEquals("Title", output.getTitle());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = DozerMapper.parseListObjects(inputObject.mockVOList(), Book.class);
        Book outputZero = outputList.get(0);
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Author Name Test0", outputZero.getAuthor());
        assertEquals("Launch Date Test0", outputZero.getLaunchDate());
        assertEquals("Price Test0", outputZero.getPrice());
        assertEquals("Title", outputZero.getTitle());
        
        Book outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Author Name Test7", outputSeven.getAuthor());
        assertEquals("Launch Date Test7", outputSeven.getLaunchDate());
        assertEquals("Price Test7", outputSeven.getPrice());
        assertEquals("Title", outputSeven.getTitle());
        
        Book outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Author Name Test12", outputTwelve.getAuthor());
        assertEquals("Launch Date Test12", outputTwelve.getLaunchDate());
        assertEquals("Price Test12", outputTwelve.getPrice());
        assertEquals("Title", outputTwelve.getTitle());
    }*/
}
