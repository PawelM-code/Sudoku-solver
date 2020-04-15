package com.solver.sudoku;

import com.solver.sudoku.controller.SudokuBoardController;
import com.solver.sudoku.domain.SudokuBoard;
import com.solver.sudoku.dto.SudokuBoardDto;
import com.solver.sudoku.mapper.SudokuBoardMapper;
import com.solver.sudoku.service.SudokuBoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SudokuBoardController.class)
public class SudokuBoardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SudokuBoardService sudokuBoardService;

    @MockBean
    private SudokuBoardMapper sudokuBoardMapper;

    @Mock
    private SudokuBoard sudokuBoard;

    @Mock
    private SudokuBoardDto sudokuBoardDto;

    @Test
    public void testGetSudokuBoard() throws Exception {
        //Given
        sudokuBoardDto = sudokuBoardMapper.mapToSuodkuBoardDto(sudokuBoard);

        //When
        when(sudokuBoardMapper.mapToSuodkuBoardDto(any())).thenReturn(sudokuBoardDto);
        when(sudokuBoardService.getSudokuBoard("111")).thenReturn(sudokuBoard);

        //Then
        mockMvc.perform(get("/v1/sudoku/111")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
