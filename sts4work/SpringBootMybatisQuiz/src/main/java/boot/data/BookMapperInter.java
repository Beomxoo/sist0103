package boot.data;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapperInter {
	
	public int getTotalCount();
	public void insertBook(BookDto dto);
	public ArrayList<BookDto> getAllDatas();
}
